package com.mary.instragram.domain.like;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.mary.instragram.domain.image.Image;
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
public class Like {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Image image;
	
	//@ManyToMany
	//두 테이블 사이의 pk만 가져와서 테이블을 생성하기 때문에 추가적 정보를 넣을 수 없음(사용빈도 낮음)
	//1:N 어노테이션 두 개를 이용해서 합해서, 중간 테이블을 만들어서 사용함
	
	@CreationTimestamp
	private Timestamp createDate;
}
