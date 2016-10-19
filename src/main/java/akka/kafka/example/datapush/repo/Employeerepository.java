package akka.kafka.example.datapush.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import akka.kafka.example.datapush.dao.Employee;



@Repository
public interface Employeerepository extends JpaRepository<Employee, Long> {
	
	public final static String FIND_DATA_TO_PUSH = "SELECT e FROM Employee e WHERE e.dataSentFlag=:flag";
	//public final static String FIND_DATA_TO_PUSH = "SELECT dp FROM DeliveryPreference dp";
	
	public final static String FIND_DATA_BY_ID = "SELECT dp FROM DeliveryPreference dp WHERE id=:id";

	@Query(FIND_DATA_TO_PUSH)
	public List<Employee> findDatatoPush(@Param("flag") String flag);
	
	

	
}
