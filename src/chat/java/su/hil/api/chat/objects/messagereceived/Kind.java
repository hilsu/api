package su.hil.api.chat.objects.messagereceived;

public class Kind {
    protected String kind;
    protected boolean isThumbnail;
    protected String thumbnailBaseKind;

    public String getKind() {
        return kind;
    }

    public boolean isThumbnail() {
        return isThumbnail;
    }

    public String getThumbnailBaseKind() {
        return thumbnailBaseKind;
    }
}
