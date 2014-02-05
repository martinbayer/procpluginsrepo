package cz.martinbayer.analyser.processor.dbinputproc.paletteitem;

import cz.martinbayer.analyser.processors.BasicProcessorPaletteItem;

public class DBInputProcPaletteItem extends BasicProcessorPaletteItem{

	private static final String LABEL = "Database input processor";

	public DBInputProcPaletteItem(){
		path = "images/icon.png";
	}
	
	@Override
	public String getLabel() {
		return LABEL;
	}



}
