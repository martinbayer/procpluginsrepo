package cz.martinbayer.analyser.processor.dbinputproc.processor;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class DisplayOutputProcLogic implements IProcessorLogic<ConcreteData> {

	private DisplayOutputProcessor processor;

	@Override
	public LogProcessor<ConcreteData> getProcessor() {
		if (processor == null) {
			processor = new DisplayOutputProcessor();
		}
		return processor;
	}

}
