package com.biat.springbootangular4authentication.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.biat.springbootangular4authentication.dao.UserRepository;
import com.biat.springbootangular4authentication.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("user.user");
        user.setFullName("aymen braiek");
        entityManager.persist(user);
        entityManager.flush();
        // when
        User testUser = userRepository.findById(user.getId()).orElse(null
        );
        // then
        assertThat(testUser.getFullName()).isEqualTo(user.getFullName());
    }

    @Test
    public void testFindByUserName() {
        User user = new User();
        user.setUsername("user.user2");
        user.setFullName("ahlem chargui");
        entityManager.persist(user);
        entityManager.flush();
        User usertest = userRepository.findByUsername(user.getUsername());

        assertThat(user.getUsername()).isEqualTo(usertest.getUsername());

    }
}
