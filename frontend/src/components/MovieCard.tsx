import NotFound from "../assets/404.gif";

interface Results {
    media: Media;
}

interface Media {
    imdbID: string;
    Year: string;
    Poster: string;
    Title: string;
    Type: string;
}

function MovieCard({ media }: Results) {
    return (
        <div className="movie" key={media.imdbID}>
            <div>
                <p>{media.Year}</p>
            </div>

            <div>
                <img
                    src={media.Poster !== "N/A" ? media.Poster : NotFound}
                    alt={media.Title}
                    onError={(e) => {
                        e.currentTarget.src = NotFound;
                    }}
                />
            </div>

            <div>
                <span>{media.Type}</span>
                <h3>{media.Title}</h3>
            </div>
        </div>
    );
}

export default MovieCard;
