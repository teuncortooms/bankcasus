package Client;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class ClientConverterTests {

    @Test
    void convertToClientDTO() {
    }

    @Test
    public void testIfMappingWorksWithUUID() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UUID uuidToMap = UUID.randomUUID();
        UUID mappedUUID = mapper.map(uuidToMap, UUID.class);

        assertTrue(mappedUUID == uuidToMap);
    }
}