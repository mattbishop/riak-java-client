/*
 * This file is provided to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.basho.riak.client.mapreduce.filter;

import org.json.JSONArray;

/**
 * @deprecated with the addition of a protocol buffers client in 0.14 all the
 *             existing REST client code should be in client.http.* this class
 *             has therefore been moved. Please use
 *             com.basho.riak.client.http.mapreduce.filter.LogicalNotFilter
 *             instead.
 *             <p>WARNING: This class will be REMOVED in the next version.</p>
 * @see com.basho.riak.client.http.mapreduce.filter.LogicalNotFilter
 */
@Deprecated
public class LogicalNotFilter implements MapReduceFilter {
    private MapReduceFilter.Types type = MapReduceFilter.Types.LOGICAL;
    private JSONArray args = new JSONArray();

    public LogicalNotFilter(MapReduceFilter... filters) {
        args.put("not");
        for(MapReduceFilter filter: filters) {
            args.put(filter.toJson());
        }
    }

    public LogicalNotFilter add(MapReduceFilter filter) {
        args.put(filter.toJson());
        return this;
    }
    
    public JSONArray toJson() {
        return args;
    }
}
