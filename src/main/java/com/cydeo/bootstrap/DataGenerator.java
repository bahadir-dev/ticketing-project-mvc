package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }


    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        // add data to map -> save()

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John","Keso","john@cydeo.com","Abc1",true,"745121215",managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa","Nor","delisa@cydeo.com","123",true,"524121215",managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig","Kack","craig@cydeo.com","Abc5",true,"745124578",employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shawn","Hiat","shawn@cydeo.com","DFg1",true,"745656215",managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike","Dyke","mike@cydeo.com","set1",true,"745126987",adminRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elisa","Hype","elisa@cydeo.com","elsa1",true,"7423234215",employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria","Ada","maria@cydeo.com","1234v",true,"745124711",employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill","Matt","bill@cydeo.com","fros6",true,"745121144",employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user1, LocalDate.now(),LocalDate.now().plusDays(32),"Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);




    }
}
