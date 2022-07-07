package com.example.ScheduleDemo.Repository;

import com.example.ScheduleDemo.Entities.Emails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Emails, Long> {

}
