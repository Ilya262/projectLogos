package logos.ua.projectLogos.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bucket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Date purchaseDate;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "periodical_id", referencedColumnName = "id")
	private Periodical periodical;

	public Bucket() {
		super();
	}

	public Bucket(Integer id, Date purchaseDate, User user, Periodical periodical) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.user = user;
		this.periodical = periodical;
	}

	public Bucket(Date purchaseDate, User user, Periodical periodical) {
		super();
		this.purchaseDate = purchaseDate;
		this.user = user;
		this.periodical = periodical;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Periodical getPeriodical() {
		return periodical;
	}

	public void setPeriodical(Periodical periodical) {
		this.periodical = periodical;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((periodical == null) ? 0 : periodical.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (periodical == null) {
			if (other.periodical != null)
				return false;
		} else if (!periodical.equals(other.periodical))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", purchaseDate=" + purchaseDate + ", user=" + user + ", periodical=" + periodical
				+ "]";
	}

	
	
	
}
