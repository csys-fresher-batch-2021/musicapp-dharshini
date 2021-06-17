package in.dharshini.model;

public class Language {
	private String languageName;
	private Integer languageId;

	public Language(String languageName) {
		super();
		this.languageName = languageName;
	}

	public Language(Integer languageId) {
		super();
		this.languageId = languageId;
	}

	public Language(String languageName, Integer languageId) {
		super();
		this.languageName = languageName;
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "Language [languageName=" + languageName + ", languageId=" + languageId + "]";
	}
}