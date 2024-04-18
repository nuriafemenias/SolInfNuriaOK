package balletApp.balletOK.gui;

import processing.core.PApplet;

public class Tabla {

    String[] tableHeaders;
    String[][] tableData;
    float[] columnWidths;
    int numCols, numRows;

    public Tabla(int nr, int nc){
        this.numRows = nr;
        this.numCols = nc;
    }


    public void setHeaders(String[] h){
        this.tableHeaders = h;
    }

    public void setData(String[][] d){
        this.tableData = d;
    }

    public void setValueAt(String value, int nr, int nc){
        this.tableData[nr][nc] = value;
    }

    public void setColumnWidths(float[] w){
        this.columnWidths = w;
    }

    public void display(PApplet p5, float x, float y, float w, float h){
        p5.pushStyle();
        p5.fill(200, 50); p5.stroke(0); p5.strokeWeight(3);
        p5.rect(x, y, w, h);

        float rowHeight = h / numRows;
        p5.fill(200, 100, 100); p5.stroke(0); p5.strokeWeight(3);
        p5.rect(x, y, w, rowHeight);

        p5.stroke(0);
        for(int r = 1; r <numRows; r++){
            if(r==1){ p5.strokeWeight(3); }
            else {    p5.strokeWeight(1); }
            p5.line(x, y + r*rowHeight, x + w, y + r*rowHeight);
        }

        float xCol = x;
        for(int c = 0; c<numCols; c++){
            xCol += w*columnWidths[c]/100.0;
            p5.line(xCol, y, xCol, y + h);
        }

        p5.fill(0); p5.textSize(24);
        for(int r = 0; r< numRows; r++){
            xCol = x;
            for(int c = 0; c< numCols; c++){
                if(r==0){
                    p5.text(tableHeaders[c], xCol + 10, y + (r+1)*rowHeight - 10);
                }
                else{
                    p5.text(tableData[r-1][c], xCol + 10, y + (r+1)*rowHeight - 10);
                }
                xCol += w*columnWidths[c]/100.0;
            }
        }
        p5.popStyle();
    }
}
