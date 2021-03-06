package myapps.solutions.huddil.model;
// Generated Nov 17, 2017 4:19:00 PM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * BookingHistory generated by hbm2java
 */
@SqlResultSetMapping(name = "report", classes = { @ConstructorResult(targetClass = Report.class, columns = {
		@ColumnResult(name = "sum"), @ColumnResult(name = "date") }) })
@Entity
@Table(name = "booking_history", catalog = "huddil", uniqueConstraints = @UniqueConstraint(columnNames = "paymentId"))
public class BookingHistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1687259192600172968L;
	private Integer id;
	private Facility facility;
	private UserPref userPref;
	private Date fromDateTime;
	private Date toDateTime;
	private Date bookedTime;
	private double price;
	private String paymentMethod;
	private int bookingId;
	private String paymentId;
	private int seats;
	private Date approvedTime;
	private List<Review> reviews = new ArrayList<Review>(0);

	public BookingHistory() {
	}

	public BookingHistory(Facility facility, UserPref userPref, double price, String paymentMethod, int bookingId,
			int seats) {
		this.facility = facility;
		this.userPref = userPref;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.bookingId = bookingId;
		this.seats = seats;
	}

	public BookingHistory(Facility facility, UserPref userPref, Date fromDateTime, Date toDateTime, Date bookedTime,
			double price, String paymentMethod, int bookingId, String paymentId, int seats, Date approvedTime,
			List<Review> reviews) {
		this.facility = facility;
		this.userPref = userPref;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.bookedTime = bookedTime;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.bookingId = bookingId;
		this.paymentId = paymentId;
		this.seats = seats;
		this.approvedTime = approvedTime;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facilityId", nullable = false)
	@JsonIgnore
	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	public UserPref getUserPref() {
		return this.userPref;
	}

	public void setUserPref(UserPref userPref) {
		this.userPref = userPref;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fromDateTime", nullable = false, length = 19)
	public Date getFromDateTime() {
		return this.fromDateTime;
	}

	public void setFromDateTime(Date fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "toDateTime", nullable = false, length = 19)
	public Date getToDateTime() {
		return this.toDateTime;
	}

	public void setToDateTime(Date toDateTime) {
		this.toDateTime = toDateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bookedTime", nullable = false, length = 19)
	public Date getBookedTime() {
		return this.bookedTime;
	}

	public void setBookedTime(Date bookedTime) {
		this.bookedTime = bookedTime;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "paymentMethod", nullable = false, length = 10)
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(name = "bookingId", nullable = false)
	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Column(name = "paymentId", unique = true, length = 45)
	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "seats", nullable = false)
	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approvedTime", length = 19)
	public Date getApprovedTime() {
		return this.approvedTime;
	}

	public void setApprovedTime(Date approvedTime) {
		this.approvedTime = approvedTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingHistory")
	@JsonIgnore
	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
