package id.xaxxis.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photoBanner;
    private int photoCover;
    private String title;
    private String dateRelease;
    private String rating;
    private String genre;
    private String duration;
    private String synopsis;
    private String category;


    public int getPhotoBanner() {
        return photoBanner;
    }

    public void setPhotoBanner(int photoBanner) {
        this.photoBanner = photoBanner;
    }

    public int getPhotoCover() {
        return photoCover;
    }

    public void setPhotoCover(int photoCover) {
        this.photoCover = photoCover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoBanner);
        dest.writeInt(this.photoCover);
        dest.writeString(this.title);
        dest.writeString(this.dateRelease);
        dest.writeString(this.rating);
        dest.writeString(this.genre);
        dest.writeString(this.duration);
        dest.writeString(this.synopsis);
        dest.writeString(this.category);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photoBanner = in.readInt();
        this.photoCover = in.readInt();
        this.title = in.readString();
        this.dateRelease = in.readString();
        this.rating = in.readString();
        this.genre = in.readString();
        this.duration = in.readString();
        this.synopsis = in.readString();
        this.category = in.readString();
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
