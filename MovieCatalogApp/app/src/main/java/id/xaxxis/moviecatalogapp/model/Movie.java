package id.xaxxis.moviecatalogapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photoCover;
    private String movieTitle;
    private String movieYear;
    private String movieRating;
    private String movieGenre;
    private String movieDuration;
    private String movieSynopsis;



    public int getPhotoCover() {
        return photoCover;
    }

    public void setPhotoCover(int photoCover) {
        this.photoCover = photoCover;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoCover);
        dest.writeString(this.movieTitle);
        dest.writeString(this.movieYear);
        dest.writeString(this.movieRating);
        dest.writeString(this.movieGenre);
        dest.writeString(this.movieDuration);
        dest.writeString(this.movieSynopsis);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photoCover = in.readInt();
        this.movieTitle = in.readString();
        this.movieYear = in.readString();
        this.movieRating = in.readString();
        this.movieGenre = in.readString();
        this.movieDuration = in.readString();
        this.movieSynopsis = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
