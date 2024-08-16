import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import "./movieInfoPage.css";

class MovieInfo {
    name: string = "";
    alternateTitles: string[] = [];
    year: Number = 0;
    poster: string = "";
    backgroundImage: string = "";
    director: string = "";
    producer: string = "";
    music: string = "";
    duration: Number = 0;
    releaseDate: string = "";
    type: string = "";
    malScore: Number = 0;
    imdbScore: Number = 0;
    synopsis: string = "";
    images: string[] = [];
}

const API_URL = `http://localhost:6868`;

function MovieInfoPage() {
    const { movieName } = useParams();

    const [movieInfo, setMovieInfo] = useState(new MovieInfo());

    const fetchMovieInfo = async () => {
        const response = await fetch(
            `${API_URL}/fetch-movie-info?name=${movieName}`
        );
        const data = await response.json();
        setMovieInfo(data);
    };

    useEffect(() => {
        fetchMovieInfo();
    }, []);

    return (
        <div
            className="movie-info"
            style={{
                background: `linear-gradient( to right, rgba(0, 0, 0, 0.85), rgba(0, 0, 0, 0.9), rgba(0, 0, 0, 0.9) ), center / cover fixed url(${movieInfo.backgroundImage}) no-repeat`,
                // backdropFilter: "blur(10px)",
            }}
        >
            <h1>{movieInfo.name}</h1>
            <div className="poster-container">
                <img src={movieInfo.poster} alt={`${movieInfo.name} poster`} />
                <div className="poster-overlay">
                    {movieInfo.year.toString()}
                </div>
            </div>

            <div className="alternate-titles">
                <strong>Alternate Titles:</strong>
                {movieInfo.alternateTitles.map((title) => (
                    <h3 key={title}>{title}</h3>
                ))}
            </div>
            <div className="movie-details">
                <p>
                    <strong>Director</strong> {movieInfo.director}
                </p>
                <p>
                    <strong>Producer</strong> {movieInfo.producer}
                </p>
                <p>
                    <strong>Music</strong> {movieInfo.music}
                </p>
                <p>
                    <strong>Duration</strong> {movieInfo.duration.toString()}{" "}
                    minutes
                </p>
                <p>
                    <strong>Release Date</strong> {movieInfo.releaseDate}
                </p>
                <p>
                    <strong>Type</strong> {movieInfo.type}
                </p>
                {movieInfo.malScore != 0 ? (
                    <p>
                        <strong>MAL Score</strong>{" "}
                        {movieInfo.malScore.toString()}
                    </p>
                ) : (
                    ""
                )}
                <p>
                    <strong>IMDB Score</strong> {movieInfo.imdbScore.toString()}
                </p>
            </div>
            <div className="synopsis">
                <p dangerouslySetInnerHTML={{ __html: movieInfo.synopsis }} />
            </div>

            <div className="images">
                {movieInfo.images.map((image, index) => (
                    <img key={index} src={image} alt={`Scene ${index + 1}`} />
                ))}
            </div>
        </div>
    );
}

export default MovieInfoPage;
