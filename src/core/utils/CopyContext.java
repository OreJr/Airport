package core.utils;

import java.util.IdentityHashMap;
import java.util.Map;

public class CopyContext {
    private final Map<Object, Object> copiedObjects = new IdentityHashMap<>();

    @SuppressWarnings("unchecked") // Justificado porque controlamos lo que entra y sale del mapa.
    public <T> T getCopied(T original) {
        return (T) copiedObjects.get(original);
    }

    public <T> void registerCopy(T original, T copy) {
        if (original == null || copy == null) {
            return;
        }
        copiedObjects.put(original, copy);
    }
}