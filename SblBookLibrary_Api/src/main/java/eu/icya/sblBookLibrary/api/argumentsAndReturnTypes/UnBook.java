package eu.icya.sblBookLibrary.api.argumentsAndReturnTypes;

import java.util.Collections;
import java.util.Set;

public class UnBook {
	private String title;
	private String subtitle;
	private String edition;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Set<UnAuthor> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<UnAuthor> authors) {
		this.authors = authors;
	}

	private Set<UnAuthor> authors = Collections.emptySet();
}
