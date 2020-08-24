package com.mary.instragram.domain.image;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mary.instragram.domain.tag.Tag;
import com.mary.instragram.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String location;
	private String caption;
	private String imageUrl;
	
	
	//Image를 select를 하면 한 명의 User가 옴
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId") //컬럼명
	private User user; //타입 : User옵젝트의 pk
	
	//Image를 select하면 여러 개의 TAG가 딸려옴
	//select하기 전에 불러오지 않음 => 부하가 적음
	@OneToMany(mappedBy = "image", fetch = FetchType.LAZY) //Foreign키가 아님을 선언(연관관계의 주인이 아님) //연관관계 주인의 변수명을 적는다.
	@JsonIgnoreProperties({"image"})
	private List<Tag> tags;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
}
