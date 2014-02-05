package cz.martinbayer.analyser.processor.dbinputproc.paletteitem;

import cz.martinbayer.analyser.processors.BasicProcessorPaletteItem;

public class DisplayOutputProcPaletteItem extends BasicProcessorPaletteItem{

	private static final String LABEL = "Database input processor";

	public DisplayOutputProcPaletteItem (){
		path = "images/icon.png";
	}
	
	@Override
	public String getLabel() {
		return LABEL;
	}



}
