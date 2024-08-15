import { useEffect, useState } from "react";
import "./App.css";
import GhibliIcon from "./assets/studio-ghibli-logo.svg";
import MovieCard from "./components/MovieCard";
import SearchableDropdown from "./components/SearchableDropdown";

const API_URL = `http://localhost:6868`;

function App() {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        fetchAllMovieCards();
    }, []);

    const searchMovies = async (searchString: string) => {
        const response = await fetch(
            `${API_URL}/fetch-all-movie-cards-like?name=${searchString}`
        );
        if (response.status === 204) {
            setMovies([]);
        } else {
            const data = await response.json();
            setMovies(data);
        }
    };

    const fetchAllMovieCards = async () => {
        const response = await fetch(`${API_URL}/fetch-all-movie-cards`);
        const data = await response.json();
        setMovies(data);
    };

    return (
        <div className="app">
            <div className="ghibli">
                <img src={GhibliIcon} />
            </div>

            <SearchableDropdown api_url={API_URL} searchMovies={searchMovies} />

            {movies?.length > 0 ? (
                <div className="container">
                    {movies.map((media, index) => (
                        <MovieCard key={index} media={media} />
                    ))}
                </div>
            ) : (
                <div className="empty">
                    <h2>No movies found</h2>
                </div>
            )}
        </div>
    );
}

export default App;

// https://www.formyanime.com/2024/04/studio-ghibli-ultra-widescreen-wallpaper.html
// https://drive.google.com/drive/folders/1RPcT-Jm0i2h7cIh0OHRnP_sxjU5pYq2h
// https://myanimelist.net/anime/199/Sen_to_Chihiro_no_Kamikakushi
