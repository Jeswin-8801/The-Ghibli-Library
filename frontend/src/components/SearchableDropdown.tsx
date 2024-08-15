import { useEffect, useRef, useState } from "react";
import SearchIcon from "../assets/search.svg";

interface Search {
    api_url: string;
    searchMovies: (item: string) => void;
}

interface FetchMovieNameDto {
    name: string;
}

function SearchableDropdown({ api_url, searchMovies }: Search) {
    const [searchTerm, setSearchTerm] = useState("");
    const [movieNamesList, setMovieNamesList] = useState([] as any);
    const [isOpen, setIsOpen] = useState(false);

    useEffect(() => {
        document.addEventListener("click", toggle);
        return () => document.removeEventListener("click", toggle);
    }, []);

    const inputRef = useRef(null);

    function toggle(e: any) {
        setIsOpen(e && e.target === inputRef.current);
    }

    const fetchMovieNamesFromSearch = async (searchString: string) => {
        const response = await fetch(
            `${api_url}/fetch-all-movie-names-like?name=${searchString}`
        );
        if (response.status === 200) {
            const data = await response.json();
            let tempArray: string[] = [];
            data.map((movieName: FetchMovieNameDto) => {
                if (!movieNamesList.includes(movieName.name))
                    tempArray.push(movieName.name);
            });
            setMovieNamesList([...movieNamesList, ...tempArray]);
            setIsOpen(true);
        } else setMovieNamesList(Array());
    };

    const filter = (movieNamesList: []) => {
        return movieNamesList.filter(
            (movieItem: string) =>
                movieItem.toLowerCase().indexOf(searchTerm.toLowerCase()) > -1
        );
    };

    const selectOption = (option: string) => {
        setSearchTerm(option);
        setIsOpen(false);
    };

    useEffect(() => {
        if (movieNamesList.includes(searchTerm)) setMovieNamesList(Array());
    }, [isOpen]);

    const getDisplayValue = () => {
        if (searchTerm) return searchTerm;
        return "";
    };

    useEffect(() => {
        if (searchTerm.length >= 3) {
            fetchMovieNamesFromSearch(searchTerm);
        } else {
            setMovieNamesList(Array());
            setIsOpen(false);
        }
    }, [searchTerm]);

    return (
        <>
            <div
                className="search"
                style={{
                    borderRadius:
                        isOpen &&
                        searchTerm.length >= 3 &&
                        movieNamesList.length > 0
                            ? "1rem"
                            : "3rem",
                }}
            >
                <input
                    ref={inputRef}
                    value={getDisplayValue()}
                    type="text"
                    onChange={(e) => setSearchTerm(e.target.value)}
                    onKeyDown={(e) => {
                        if (e.key === "Enter") searchMovies(searchTerm);
                    }}
                    onClick={toggle}
                    placeholder="Search for movies"
                />
                <img
                    src={SearchIcon}
                    alt="search"
                    onClick={() => searchMovies(searchTerm)}
                />
            </div>

            {isOpen && movieNamesList.length > 0 ? (
                <div className="dropdown">
                    {filter(movieNamesList).map((option: string, index) => {
                        return (
                            <div
                                onClick={() => selectOption(option)}
                                className="option"
                                key={`${index}`}
                            >
                                {option}
                            </div>
                        );
                    })}
                </div>
            ) : (
                ""
            )}
        </>
    );
}

export default SearchableDropdown;
