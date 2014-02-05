package cz.martinbayer.analyser.processor.dbinputproc;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processor.dbinputproc.paletteitem.DBInputProcPaletteItem;
import cz.martinbayer.analyser.processor.dbinputproc.processor.DBInputProcessorLogic;
import cz.martinbayer.analyser.processors.IProcessorItemWrapper;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.IProcessorsPaletteItem;

public class DBInputProcessorItemWrapper implements IProcessorItemWrapper<ConcreteData>{

	@Override
	public IProcessorLogic<ConcreteData> getProcessorLogic() {
		return new DBInputProcessorLogic();
	}

	@Override
	public IProcessorsPaletteItem getProcessorPaletteItem() {
		return new DBInputProcPaletteItem();
	}

}
