package cz.martinbayer.analyser.impl;

import cz.martinbayer.analyser.processors.model.ELogLevel;
import cz.martinbayer.analyser.processors.model.IXMLog;

public class ConcreteData implements IXMLog {

	private ELogLevel logLevel;
	private String text;
	private boolean removed;

	public ConcreteData(ELogLevel logLevel, String text, boolean removed) {
		super();
		this.logLevel = logLevel;
		this.text = text;
		this.removed = removed;
	}

	@Override
	public ELogLevel getLogLevel() {
		return this.logLevel;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public boolean isRemoved() {
		return this.removed;
	}

	@Override
	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	@Override
	public void setLogLevel(ELogLevel logLevel) {
		this.logLevel = logLevel;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	public String getMessage(){
		return "message from concrete data";
	}

	@Override
	public String toString() {
		return "ConcreteData [logLevel=" + logLevel + ", text=" + text
				+ ", removed=" + removed + "]";
	}
	
}
