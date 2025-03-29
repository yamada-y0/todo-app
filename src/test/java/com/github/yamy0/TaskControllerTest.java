package com.github.yamy0;

import com.github.yamy0.adapter.in.web.TaskController;
import com.github.yamy0.application.port.in.CreateTaskCommand;
import com.github.yamy0.domain.model.Status;
import com.github.yamy0.domain.model.Task;
import com.github.yamy0.infrastructure.persistence.TaskEntity;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.vertx.VertxContextSupport;
import io.restassured.http.ContentType;
import jakarta.enterprise.event.Observes;
import org.hibernate.reactive.mutiny.Mutiny;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(TaskController.class)
class TaskControllerTest {
    void onStart(@Observes StartupEvent event, Mutiny.SessionFactory sf) throws Throwable {
        VertxContextSupport.subscribeAndAwait(() -> sf.withTransaction(session -> session.persist(
                TaskEntity.from(new Task("id", "test", LocalDate.of(2021, 1, 1), Status.TODO))
        )));
    }

    @Test
    void testGetTask() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].id", is("id"))
                .body("[0].name", is("test"));
    }

    @Test
    void testPostTask() {
        String taskName = "test";
        LocalDate dueDate = LocalDate.of(2021, 1, 1);
        CreateTaskCommand command = new CreateTaskCommand(taskName, dueDate);
        given()
                .contentType(ContentType.JSON)
                .body(command)
                .when().post()
                .then()
                .statusCode(201)
                .body("name", is(taskName))
                .body("dueDate", is(dueDate.toString()));
    }
}
