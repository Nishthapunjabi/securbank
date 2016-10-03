package securbank.models;

import java.awt.geom.Arc2D.Double;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.LocalDateTime;

/**
 * @author Shivani Jhunjhunwala
 *
 */
@Entity
@Table(name = "CreditCard")
public class CreditCard {
	
	/**
	 * @param ccID
	 * @param account
	 * @param limit
	 * @param used
	 * @param activeBalance
	 * @param active
	 * @param createdOn
	 */
	public CreditCard(UUID ccID, Account account, Double maxLimit, Double used, Double activeBalance, Boolean active,
			LocalDateTime createdOn) {
		super();
		this.ccID = ccID;
		this.account = account;
		this.maxLimit = maxLimit;
		this.used = used;
		this.activeBalance = activeBalance;
		this.active = active;
		this.createdOn = createdOn;
	}

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@NotNull
	@Column(name = "ccID", unique = true, nullable = false, columnDefinition = "BINARY(16)")
	private UUID ccID;

	@NotNull
	@Column(name = "maxLimit", nullable = false)
	private Double maxLimit;

	@NotNull
	@Column(name = "used", nullable = false)
	private Double used;

	@NotNull
	@Column(name = "activeBalance", nullable = false)
	private Double activeBalance;

	@NotNull
	@Column(name = "active", nullable = false, columnDefinition = "BIT")
	private Boolean active;

	@NotNull
	@Column(name = "createdOn", nullable = false, updatable = false)
	private LocalDateTime createdOn;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber", nullable = false)
	private Account account;

	/**
	 * @return the ccID
	 */
	public UUID getCcID() {
		return ccID;
	}

	/**
	 * @param ccID the ccID to set
	 */
	public void setCcID(UUID ccID) {
		this.ccID = ccID;
	}

	/**
	 * @return the accountID
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the limit
	 */
	public Double getMaxLimit() {
		return maxLimit;
	}
	
	/**
	 * @param maxLimit the maxLimit to set
	 */
	public void setMaxLimit(Double maxLimit) {
		this.maxLimit = maxLimit;
	}

	/**
	 * @return the used
	 */
	public Double getUsed() {
		return used;
	}

	/**
	 * @param used the used to set
	 */
	public void setUsed(Double used) {
		this.used = used;
	}

	/**
	 * @return the activeBalance
	 */
	public Double getActiveBalance() {
		return activeBalance;
	}

	/**
	 * @param activeBalance the activeBalance to set
	 */
	public void setActiveBalance(Double activeBalance) {
		this.activeBalance = activeBalance;
	}

	/**
	 * @return the active status
	 */
	public Boolean getActive() {
		return active;
	}
	
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the createdOn Date
	 */
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "CreditCard [ccID=" + ccID + ", account=" + account + ", maxLimit=" + maxLimit + ", used=" + used
				+ ", activeBalance=" + activeBalance + ", active=" + active + ", createdOn=" + createdOn + "]";
	}

}