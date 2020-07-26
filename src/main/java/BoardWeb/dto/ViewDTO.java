package BoardWeb.dto;

import java.sql.Timestamp;

public class ViewDTO {
    protected Long id;
    protected Long board_id;
    protected String viewer;
    protected Timestamp viewed_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public Timestamp getViewed_at() {
        return viewed_at;
    }

    public void setViewed_at(Timestamp viewed_at) {
        this.viewed_at = viewed_at;
    }
}
