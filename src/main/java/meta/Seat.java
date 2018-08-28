package meta;

public class Seat {
    private String Id;
    private String OriginalStatus;
    private Position Position;
    private String SeatStyle;
    private String Status;
    private int RowId;
    private String AreaCategoryCode;
    private String ElementId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOriginalStatus() {
        return OriginalStatus;
    }

    public void setOriginalStatus(String originalStatus) {
        OriginalStatus = originalStatus;
    }

    public Seat.Position getPosition() {
        return Position;
    }

    public void setPosition(Seat.Position position) {
        Position = position;
    }

    public String getSeatStyle() {
        return SeatStyle;
    }

    public void setSeatStyle(String seatStyle) {
        SeatStyle = seatStyle;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getRowId() {
        return RowId;
    }

    public void setRowId(int rowId) {
        RowId = rowId;
    }

    public String getAreaCategoryCode() {
        return AreaCategoryCode;
    }

    public void setAreaCategoryCode(String areaCategoryCode) {
        AreaCategoryCode = areaCategoryCode;
    }

    public String getElementId() {
        return ElementId;
    }

    public void setElementId(String elementId) {
        ElementId = elementId;
    }

    class Position{
        private int AreaNumber;
        private int ColumnIndex;
        private int RowIndex;

        public int getAreaNumber() {
            return AreaNumber;
        }

        public void setAreaNumber(int areaNumber) {
            AreaNumber = areaNumber;
        }

        public int getColumnIndex() {
            return ColumnIndex;
        }

        public void setColumnIndex(int columnIndex) {
            ColumnIndex = columnIndex;
        }

        public int getRowIndex() {
            return RowIndex;
        }

        public void setRowIndex(int rowIndex) {
            RowIndex = rowIndex;
        }
    }
}
