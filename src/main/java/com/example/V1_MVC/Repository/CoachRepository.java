
package com.example.V1_MVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.V1_MVC.Model.CoachModel;


@Repository
public interface CoachRepository extends JpaRepository<CoachModel, Long> {
}
