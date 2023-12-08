package modal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Psillovits
 */
@Entity
@Table(name = "DRAW_OPAP_JOKER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrawOpapJoker.findAll", query = "SELECT d FROM DrawOpapJoker d")
    , @NamedQuery(name = "DrawOpapJoker.findAllGameIdASC", query = "SELECT d FROM DrawOpapJoker d ORDER BY d.gameid ASC")
    , @NamedQuery(name = "DrawOpapJoker.findById", query = "SELECT d FROM DrawOpapJoker d WHERE d.id = :id")
    , @NamedQuery(name = "DrawOpapJoker.findByGameid", query = "SELECT d FROM DrawOpapJoker d WHERE d.gameid = :gameid")
    , @NamedQuery(name = "DrawOpapJoker.findByDrawid", query = "SELECT d FROM DrawOpapJoker d WHERE d.drawid = :drawid")
    , @NamedQuery(name = "DrawOpapJoker.findByDrawtime", query = "SELECT d FROM DrawOpapJoker d WHERE d.drawtime = :drawtime")
    , @NamedQuery(name = "DrawOpapJoker.findByWinningnumbers", query = "SELECT d FROM DrawOpapJoker d WHERE d.winningnumbers = :winningnumbers")
    , @NamedQuery(name = "DrawOpapJoker.findByBonusnumber", query = "SELECT d FROM DrawOpapJoker d WHERE d.bonusnumber = :bonusnumber")
    , @NamedQuery(name = "DrawOpapJoker.findByDrawtimeWithRange", query = "SELECT d FROM DrawOpapJoker d WHERE d.drawtime >= :start AND d.drawtime <= :end")
    , @NamedQuery(name = "DrawOpapJoker.findByCountwinners", query = "SELECT d FROM DrawOpapJoker d WHERE d.countwinners = :countwinners")
    , @NamedQuery(name = "DrawOpapJoker.findByDivident", query = "SELECT d FROM DrawOpapJoker d WHERE d.divident = :divident")
    , @NamedQuery(name = "DrawOpapJoker.findByDistributed", query = "SELECT d FROM DrawOpapJoker d WHERE d.distributed = :distributed")
    , @NamedQuery(name = "DrawOpapJoker.findByJackpot", query = "SELECT d FROM DrawOpapJoker d WHERE d.jackpot = :jackpot")})
public class DrawOpapJoker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "GAMEID")
    private int gameid;
    @Basic(optional = false)
    @Column(name = "DRAWID")
    private int drawid;
    @Basic(optional = false)
    @Column(name = "DRAWTIME")
    @Temporal(TemporalType.DATE)
    private Date drawtime;
    @Basic(optional = false)
    @Column(name = "WINNINGNUMBERS")
    private String winningnumbers;
    @Basic(optional = false)
    @Column(name = "BONUSNUMBER")
    private int bonusnumber;
    @Basic(optional = false)
    @Column(name = "COUNTWINNERS")
    private String countwinners;
    @Basic(optional = false)
    @Column(name = "DIVIDENT")
    private String divident;
    @Basic(optional = false)
    @Column(name = "DISTRIBUTED")
    private String distributed;
    @Basic(optional = false)
    @Column(name = "JACKPOT")
    private String jackpot;

    public DrawOpapJoker() {
    }

    public DrawOpapJoker(Integer id) {
        this.id = id;
    }

    public DrawOpapJoker(Integer id, int gameid, int drawid, Date drawtime, String winningnumbers, int bonusnumber, String countwinners, String divident, String distributed, String jackpot) {
        this.id = id;
        this.gameid = gameid;
        this.drawid = drawid;
        this.drawtime = drawtime;
        this.winningnumbers = winningnumbers;
        this.bonusnumber = bonusnumber;
        this.countwinners = countwinners;
        this.divident = divident;
        this.distributed = distributed;
        this.jackpot = jackpot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getDrawid() {
        return drawid;
    }

    public void setDrawid(int drawid) {
        this.drawid = drawid;
    }

    public Date getDrawtime() {
        return drawtime;
    }

    public void setDrawtime(Date drawtime) {
        this.drawtime = drawtime;
    }

    public String getWinningnumbers() {
        return winningnumbers;
    }

    public void setWinningnumbers(String winningnumbers) {
        this.winningnumbers = winningnumbers;
    }

    public int getBonusnumber() {
        return bonusnumber;
    }

    public void setBonusnumber(int bonusnumber) {
        this.bonusnumber = bonusnumber;
    }

    public String getCountwinners() {
        return countwinners;
    }

    public void setCountwinners(String countwinners) {
        this.countwinners = countwinners;
    }

    public String getDivident() {
        return divident;
    }

    public void setDivident(String divident) {
        this.divident = divident;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    public String getJackpot() {
        return jackpot;
    }

    public void setJackpot(String jackpot) {
        this.jackpot = jackpot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DrawOpapJoker)) {
            return false;
        }
        DrawOpapJoker other = (DrawOpapJoker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.DrawOpapJoker[ id=" + id + " ]";
    }

}
