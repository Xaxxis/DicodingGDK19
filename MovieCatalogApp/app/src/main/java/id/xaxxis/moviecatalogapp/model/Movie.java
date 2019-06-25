package id.xaxxis.moviecatalogapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photoCover;
    private String movieTitle;
    private String movieSynopsist;
    private String movieYear;
    private String movieGenre;
    private String movieRating;

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

    public String getMovieSynopsist() {
        return movieSynopsist;
    }

    public void setMovieSynopsist(String movieSynopsist) {
        this.movieSynopsist = movieSynopsist;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoCover);
        dest.writeString(this.movieTitle);
        dest.writeString(this.movieSynopsist);
        dest.writeString(this.movieYear);
        dest.writeString(this.movieGenre);
        dest.writeString(this.movieRating);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photoCover = in.readInt();
        this.movieTitle = in.readString();
        this.movieSynopsist = in.readString();
        this.movieYear = in.readString();
        this.movieGenre = in.readString();
        this.movieRating = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
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
