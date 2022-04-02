public class Element {
    private int index; //
    private int pts; //
    private int played;
    private int win;
    private int draw;
    private int loose;
/*--------------------------------------------------------------------------------*/
    public Element(int index, int played, int win, int draw, int loose, int pts){
        this.index = index;
        this.pts = pts;
        this.played = played;
        this.win = win;
        this.draw = draw;
        this.loose = loose;
    }
/*--------------------------------------------------------------------------------*/
    public int getElemIndex(){
        return index;
    }
/*--------------------------------------------------------------------------------*/
    public int getElemPts(){
        return pts;
    }
/*--------------------------------------------------------------------------------*/
	public int getElemLoose() {
		return loose;
	}
/*--------------------------------------------------------------------------------*/
	public int getElemIDraw() {
		return draw;
	}
/*--------------------------------------------------------------------------------*/
	public int getElemIWin() {
		return win;
	}
/*--------------------------------------------------------------------------------*/
	public int getElemPlayed() {
		return played;
	}
/*--------------------------------------------------------------------------------*/
} 
