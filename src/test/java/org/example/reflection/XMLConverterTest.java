package org.example.reflection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class XMLConverterTest {

    XMLConverter converter;

    @BeforeEach
    void setup(){
        converter = new XMLConverter();
    }

    @Test
    void convertASimpleClass() throws IllegalAccessException {
        User user = new User(1L, "luis", "123456");
        assertThat(converter.convert(user),
                is("""
                <user>
                <id>1</id>
                <username>luis</username>
                <password>123456</password>
                </user>"""));
    }

    @Test
    void convertAComposedClass() throws IllegalAccessException {
        User user = new User(1L, "luis", "123456");
        People people = new People(1L, "Luis", user);
        assertThat(converter.convert(people),
                is("""
                <people>
                <id>1</id>
                <name>Luis</name>
                <user>
                <id>1</id>
                <username>luis</username>
                <password>123456</password>
                </user>
                </people>"""));
    }


    private class User {
        private final Long id;
        private final String username;
        private final String password;

        public User(Long id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }
    }

    private class People {
        private final Long id;
        private final String name;
        private final User user;

        public People(Long id, String name, User user) {
            this.id = id;
            this.name = name;
            this.user = user;
        }
    }
}
