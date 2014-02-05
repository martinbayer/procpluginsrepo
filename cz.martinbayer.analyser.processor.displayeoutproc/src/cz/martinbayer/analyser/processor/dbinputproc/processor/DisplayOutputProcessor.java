package cz.martinbayer.analyser.processor.dbinputproc.processor;

import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.dialogs.MessageDialog;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processor.displayeoutproc.Activator;
import cz.martinbayer.analyser.processors.types.OutputProcessor;

public class DisplayOutputProcessor extends OutputProcessor<ConcreteData> {

	private static final String NAME = "Display output";

	private StringBuffer sb = new StringBuffer();

	@Override
	protected void process() {
		if (logData != null) {
			for (ConcreteData l : logData.getLogRecords()) {
				sb.append(logDataToString(l)).append("\n");
			}
		}
	}

	private StringBuffer logDataToString(ConcreteData l) {
		StringBuffer sb = new StringBuffer();
		sb.append("Level:").append(l.getLogLevel()).append("| text: ")
				.append(l.getText()).append("! class: ")
				.append(l.getClass().getName()).append(":")
				.append(l.getMessage());
		return sb;
	}

	@Override
	protected void createOutput() {
		UISynchronize sync = Activator.getEclipseContext().get(
				UISynchronize.class);
		sync.syncExec(new Runnable() {

			@Override
			public void run() {
				MessageDialog.openInformation(null, "Final data output",
						sb.toString());
			}
		});
	}

	@Override
	public String getName() {
		return NAME;
	}

	public String getStringRow(ConcreteData data) {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(data.getLogLevel().toString()).append("]");
		sb.append("-").append(data.getText()).append(":")
				.append(data.getMessage());
		sb.append("; Class = ").append(data.getClass().getName());
		return sb.toString();
	}
}