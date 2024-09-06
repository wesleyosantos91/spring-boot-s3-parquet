package io.github.wesleyosantos91.sor;

import com.jerolba.carpet.annotation.Alias;

public record PersonSor(
        @Alias("nome") String name,
        @Alias("sobrenome")String lastName,
        @Alias("idade") Integer age,
        @Alias("email") String email) {
}
