package com.bayan.sigaw.sentiment.model;



public class Results {
	
	private String status;
	private String usage;
	private String url;
	private String language;
	private DocSentiment docSentiment;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}	
	public DocSentiment getDocSentiment() {
		return docSentiment;
	}

	public void setDocSentiment(DocSentiment docSentiment) {
		this.docSentiment = docSentiment;
	}	
}
