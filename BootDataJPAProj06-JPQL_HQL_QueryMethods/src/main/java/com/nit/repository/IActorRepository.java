package com.nit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nit.entity.Actor;

import jakarta.transaction.Transactional;

@Transactional
public interface IActorRepository extends JpaRepository<Actor, Integer> {

	// Select * from actor where category=? 
	// @Query("from Actor where category=?1")
	// @Query("from com.nit.entity.Actor a where a.category=?1")
	// @Query("Select a from com.nit.entity.Actor a where a.category=?1")
	// @Query("from Actor where category=:role")
//	public Iterable<Actor> searchActorsByCategory(String role);

	// (or)
	@Query("from Actor where category=:role")
	public Iterable<Actor> searchActorsByCategory(@Param("role") String category);

	@Query("from Actor where mobileNo in(?1,?2,?3) order by aname")
	public Iterable<Actor> findActorByMoblieNumbers(long nol, long no2, long no3);

	@Query("select aid,aname,category from Actor where category in(:cat1,:cat2,:cat3) order by aname")
	public List<Object[]> findActorsDateByCategories(String cat1, String cat2, String cat3);

	@Query("select aname from Actor where aname like :letters%")
	public List<String> findActorsNameByStartLetters(String letters);

	@Query("from Actor where mobileNo=:no")
	public Actor getActorByMobileNo(@Param("no") long mobileNo);

	@Query("select aid,aname,category from Actor where mobileNo=:ano")
	public Object getActorDataByMobileNo(long ano);

	@Query("select aname from Actor where mobileNo=:ano")
	public String getActorNameByMobileNo(long ano);

	@Query("from Actor where aid=:id")
	public Optional<Actor> findById(Integer id);

	@Query("select count(*),max(aid),min(aid),sum(aid),avg(aid) from Actor")
	public Object getActorsAggregetData();

	@Query("from Actor where aid=(select max(aid) from Actor)")
	public Actor getActorDataByMaxActorId();

	@Query("update Actor set mobileNo=:newMobileNo where aid=:id")
	@Modifying
	public int updateActorMobileNoByAid(long newMobileNo, int id);

	@Query("delete from Actor where category=:role")
	@Modifying
	public int deleteActorsByCategory(String role);
}
