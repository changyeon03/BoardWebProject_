package BoardWeb.dto;

public class CriteriaDTO {
    private int page;
    private int numPerPage;

    public CriteriaDTO() {
        this.page = 1;
        this.numPerPage =10;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {

        if(numPerPage <=0 || numPerPage > 100) {
            this.numPerPage = 10;
            return;
        }
        this.numPerPage = numPerPage;
    }
    public int getPageStart() {
        return (this.page -1) * numPerPage;
    }
}
