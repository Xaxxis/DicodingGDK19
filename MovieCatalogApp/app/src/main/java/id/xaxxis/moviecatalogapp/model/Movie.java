package id.xaxxis.moviecatalogapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photoCover;
    private String movieTitle;
    private String movieYear;
    private String movieRating;
    private String movieSynopsis;

    public Movie() {
    }

    protected Movie(Parcel in) {
        photoCover = in.readInt();
        movieTitle = in.readString();
        movieYear = in.readString();
        movieRating = in.readString();
        movieSynopsis = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photoCover);
        parcel.writeString(movieTitle);
        parcel.writeString(movieYear);
        parcel.writeString(movieRating);
        parcel.writeString(movieSynopsis);
    }
}
