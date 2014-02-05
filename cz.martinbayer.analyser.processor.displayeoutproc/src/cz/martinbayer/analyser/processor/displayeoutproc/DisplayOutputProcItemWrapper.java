package cz.martinbayer.analyser.processor.displayeoutproc;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processor.dbinputproc.paletteitem.DisplayOutputProcPaletteItem;
import cz.martinbayer.analyser.processor.dbinputproc.processor.DisplayOutputProcLogic;
import cz.martinbayer.analyser.processors.IProcessorItemWrapper;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.IProcessorsPaletteItem;

public class DisplayOutputProcItemWrapper implements
		IProcessorItemWrapper<ConcreteData> {

	private DisplayOutputProcLogic procLogic;
	private DisplayOutputProcPaletteItem paletteItem;

	@Override
	public IProcessorLogic<ConcreteData> getProcessorLogic() {
		if (procLogic == null) {
			procLogic = new DisplayOutputProcLogic();
		}
		return procLogic;
	}

	@Override
	public IProcessorsPaletteItem getProcessorPaletteItem() {
		if (paletteItem == null) {
			paletteItem = new DisplayOutputProcPaletteItem();
		}
		return paletteItem;
	}

	@Inject
	public void setContext(IEclipseContext ctx) {
		Activator.setEclipseContext(ctx);
	}

}
