package testNullAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class Snippet {
	
	public void foo() {
		@Nullable
		List<@NonNull String> list = new ArrayList<>();
		checkNotNull(list); // OK

		@Nullable
		Map<@NonNull String, @NonNull String> map = new HashMap<>();
		checkNotNull(map); // OK

		@NonNull
		Object @Nullable [] objects = null;
		// Error: Null type mismatch (type annotations): required '@NonNull Object @NonNull[]' but this expression has type '@NonNull Object @Nullable[]
		checkNotNull(objects);
	}
	
	public static <T> T[] checkNotNull(T @Nullable [] array) {
		if (array == null) {
			throw new NullPointerException();
		}
		return array;
	}

	public static <T, C extends Iterable<T>> C checkNotNull(@Nullable C container) {
		if (container == null) {
			throw new NullPointerException();
		}
		return container;
	}

	public static <K, V, M extends Map<K, V>> M checkNotNull(@Nullable M map) {
		if (map == null) {
			throw new NullPointerException();
		}
		return map;
	}
}
