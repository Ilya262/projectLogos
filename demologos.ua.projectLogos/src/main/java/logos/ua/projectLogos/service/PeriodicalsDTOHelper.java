package logos.ua.projectLogos.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import logos.ua.projectLogos.domain.Periodical;

public class PeriodicalsDTOHelper {

	public static Periodical createEntity(MultipartFile file, String name, String description, Double price)
			throws IOException {
		Periodical periodical = new Periodical();

		periodical.setName(name);
		periodical.setDescription(description);
		periodical.setPrice(price);
		periodical.setImage(file.getBytes());
		periodical.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return periodical;

	}

}
