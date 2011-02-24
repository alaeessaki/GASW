/* Copyright CNRS-CREATIS
 *
 * Rafael Silva
 * rafael.silva@creatis.insa-lyon.fr
 * http://www.creatis.insa-lyon.fr/~silva
 *
 * This software is a grid-enabled data-driven workflow manager and editor.
 *
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package fr.insalyon.creatis.gasw.executor.generator.script;

import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Rafael Silva
 */
public abstract class AbstractGenerator {

    /** 
     * Generates the code of the log functions
     *
     * @return a String containing the code
     */
    public String logFunctions() {
        StringBuilder sb = new StringBuilder();
        sb.append("function info {\n local D=`date`\n echo [ INFO - $D ] $*\n}\n");
        sb.append("function warning {\n local D=`date`\n echo [ WARN - $D ] $*\n}\n");
        sb.append("function error {\n local D=`date`\n echo [ ERROR - $D ] $* >&2\n}\n");
        return sb.toString();
    }

    /**
     * Starts a log section
     *
     * @return a String containing the bash function code
     */
    public String startLogFunction() {
        StringBuilder sb = new StringBuilder();
        sb.append("function startLog {\n echo \"<$*>\" >&1; \n echo \"<$*>\" >&2;\n}\n");
        return sb.toString();
    }

    /**
     * Stops a log section
     *
     * @return
     */
    public String stopLogFunction() {
        StringBuilder sb = new StringBuilder();
        sb.append("function stopLog {\n local logName=$1\n echo \"</${logName}>\" >&1\n echo \"</${logName}>\" >&2\n}\n");
        return sb.toString();
    }
}