package myapps.solutions.huddil.model;
// Generated Nov 17, 2017 4:19:00 PM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Amenity generated by hbm2java
 */
@Entity
@Table(name = "amenity", catalog = "huddil", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Amenity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7721303156594882066L;
	private Integer id;
	private String name;
	private String icon;
	private List<FacilityAmenity> facilityAmenities = new ArrayList<FacilityAmenity>(0);

	public Amenity() {
	}

	public Amenity(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	public Amenity(String name, String icon, List<FacilityAmenity> facilityAmenities) {
		this.name = name;
		this.icon = icon;
		this.facilityAmenities = facilityAmenities;
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

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "icon", nullable = false)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "amenity")
	@JsonIgnore
	public List<FacilityAmenity> getFacilityAmenities() {
		return this.facilityAmenities;
	}

	public void setFacilityAmenities(List<FacilityAmenity> facilityAmenities) {
		this.facilityAmenities = facilityAmenities;
	}

}
