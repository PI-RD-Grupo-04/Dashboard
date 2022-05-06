package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.rd.ved.model.Pix;

public class PixDTO {

	private Integer id;
	private String codigoPix;

	public Integer getId() {
		return id;
	}

	public String getCodigoPix() {
		return codigoPix;
	}

	public PixDTO(Pix pix) {
		this.id = pix.getId();
		this.codigoPix = pix.getCodigoPix();
	}

	public static List<PixDTO> converter(List<Pix> pixs) {
		return pixs.stream().map(PixDTO::new).collect(Collectors.toList());
	}
}