package javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer> {

}
