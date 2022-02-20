package com.misyn.assignment.repository;

import com.misyn.assignment.entity.CourierCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierCompanyRepository extends JpaRepository<CourierCompany, String> {
    CourierCompany findCourierCompanyByCompanyCode(String companyCode);
}
