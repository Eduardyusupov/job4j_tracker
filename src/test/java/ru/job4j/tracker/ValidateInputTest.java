package ru.job4j.tracker;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenManyValidInputs() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        for (int i = 1; i < 4; i++) {
            int selected = input.askInt("Enter menu");
            assertThat(selected).isEqualTo(i);
        }
    }

    @Test
    void whenInputIsNegative() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(-1);
    }
}
