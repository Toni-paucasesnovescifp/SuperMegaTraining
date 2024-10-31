/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package covas.supermegatraining;

/**
 *
 * @author Toni Covas
 */
public class Workout {


    
    private int Id;
    private String ForDate;
    private String Comments;
    private int IdUsuari;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getForDate() {
        return ForDate;
    }

    public void setForDate(String ForDate) {
        this.ForDate = ForDate;
    }

    public int getIdUsuari() {
        return IdUsuari;
    }

    public void setIdUsuari(int IdUsuari) {
        this.IdUsuari = IdUsuari;
    }
    
    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }
 
}
