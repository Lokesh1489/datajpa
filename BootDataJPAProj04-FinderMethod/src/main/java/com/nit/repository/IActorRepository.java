package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Actor;
import com.nit.entity.ResultView;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

	// select * from data_jpa_actor where aname=?
	public List<Actor> findByAnameEquals(String name);

	// select * from data_jpa_actor where aname=?
	public List<Actor> findByAnameIs(String name);

	// select * from data_jpa_actor where aname=?
	public List<Actor> findByAname(String name);

	// select * from data_jpa_actor where aid between ? and ?
	public Iterable<Actor> findByAidBetween(int start, int end);

	// select * from data_jpa_actor where aname like %?
	// select * from data_jpa_actor where aname like %?%
	// select * from data_jpa_actor where aname like ?%
	public Iterable<Actor> findByAnameLike(String chars);

	// select * from data_jpa_actor where aname like ?%
	public Iterable<Actor> findByAnameStartingWith(String chars);

	// select * from data_jpa_actor where aname like %?%
	public Iterable<Actor> findByAnameContainingIgnoreCase(String chars);

	// select * from data_jpa_actor where upper(category) in(?,?,?...) order by
	// aname asc
	public Iterable<Actor> findByCategoryInIgnoreCaseOrderByAnameAsc(List<String> categories);

	// select * from data_jpa_actor where aid<
	public Iterable<Actor> findByAidGreaterThan(int G);

	// select * from data_jpa_actor where aid>=start and aid<=end
	public Iterable<Actor> findByAidGreaterThanEqualAndAidLessThanEqual(int start, int end);

	// select * from data_jpa_actor where Status=1 or category=?
	public Iterable<Actor> findByStatusTrueOrCategoryEquals(String A);

	// Select * from data_jpa_actor where (aid>? and aid<?) or upper (Category) not
	// in (?,?,?,...)
	public Iterable<Actor> findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(int start, int end,
			List<String> categories);

	// Select aid_name from data_jpa_actor where upper(category)=?
	public Iterable<ResultView> findByCategoryEqualsIgnoreCase(String category);

	// Select aid_name from data_jpa_actor where mobileno=?
	public ResultView findByMobileNo(long mobileNo);
	
	// Select * from data_jpa_actor where mobileno=?
		public Actor findByMobileNoIs(long mobileNo);

}
