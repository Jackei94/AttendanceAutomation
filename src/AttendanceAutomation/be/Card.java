/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class Card
{

    private int cardID;
    private int loginNO;

    /**
     * Getter for id
     *
     * @return
     */
    public int getId()
    {
        return cardID;
    }

    /**
     * Setter for id
     *
     * @param id
     */
    public void setId(int id)
    {
        this.cardID = id;
    }

    /**
     * Getter for loginNO
     *
     * @return
     */
    public int getLoginNO()
    {
        return loginNO;
    }

    /**
     * Setter for loginNO
     *
     * @param login
     */
    public void setLoginNO(int login)
    {
        this.loginNO = login;
    }

}
