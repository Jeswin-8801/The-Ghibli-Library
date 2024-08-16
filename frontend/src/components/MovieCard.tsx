import { useNavigate } from "react-router-dom";
import NotFound from "../assets/404.gif";

interface Results {
    media: Media;
}

interface Media {
    name: string;
    year: Number;
    poster: string;
    duration: Number;
}

function MovieCard({ media }: Results) {
    const navigate = useNavigate();

    return (
        <div
            className="movie"
            onClick={() => {
                navigate(`/${media.name}`);
            }}
        >
            <div>
                <p>{media.year.toString()}</p>
            </div>

            <div>
                <img
                    src={media.poster !== "N/A" ? media.poster : NotFound}
                    alt={media.name}
                    onError={(e) => {
                        e.currentTarget.src = NotFound;
                    }}
                />
            </div>

            <div>
                <h5>{media.duration.toString()} min</h5>
                <h3>{media.name}</h3>
            </div>
        </div>
    );
}

export default MovieCard;
